package algorithm.fst;

import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.BytesRefBuilder;
import org.apache.lucene.util.IntsRef;
import org.apache.lucene.util.IntsRefBuilder;
import org.apache.lucene.util.fst.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 构建fst，节省大量的内存。
 * http://www.cnblogs.com/LBSer/p/4119841.html
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String inputValues[] = {"cat", "dog", "dogs"};
        long outputValues[] = {5, 7, 12};

        PositiveIntOutputs outputs = PositiveIntOutputs.getSingleton();
        Builder<Long> builder = new Builder<>(FST.INPUT_TYPE.BYTE1, outputs);
        IntsRefBuilder scratchInts = new IntsRefBuilder();
        for(int i = 0; i < inputValues.length; i++){
            //设置key，value。
            builder.add(Util.toIntsRef(new BytesRef(inputValues[i]), scratchInts), outputValues[i]);
        }
        FST<Long> fst = builder.finish();

        //根据key获取value。
        Long value = Util.get(fst, new BytesRef("dog"));
        System.out.println(value);  //7

        //根据value获取key。
        IntsRef key = Util.getByOutput(fst, 12);
        System.out.println(Util.toBytesRef(key, new BytesRefBuilder()).utf8ToString()); // dogs

        //按顺序遍历。
        BytesRefFSTEnum<Long> iterator = new BytesRefFSTEnum<Long>(fst);
        while(iterator.next() != null){
            BytesRefFSTEnum.InputOutput<Long> mapEntry = iterator.current();
            System.out.println(mapEntry.input.utf8ToString());
            System.out.println(mapEntry.output);
        }

        //求topN最短路径。
        Comparator<Long> comparator = new Comparator<Long>(){
            public int compare(Long left, Long right) {
                return left.compareTo(right);
            }
        };
        FST.Arc<Long> firstArc = fst.getFirstArc(new FST.Arc<Long>());
        Util.TopResults<Long> paths = Util.shortestPaths(fst, firstArc, fst.outputs.getNoOutput(),
                comparator, 2, true);
        Iterator<Util.Result<Long>> pathIterator = paths.iterator();
        while(pathIterator.hasNext()){
            Util.Result<Long> path = pathIterator.next();
            System.out.println(Util.toBytesRef(path.input, new BytesRefBuilder()).utf8ToString());
            System.out.println(path.output);
        }
    }
}
