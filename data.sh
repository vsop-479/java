#!/bin/sh

curl -XPOST 'localhost:9200/abc/_search?pretty' -H 'Content-Type: application/json' -d'
 {
       "query": {
         "term" : { "b.keyword" : "nbb3" }
      },
     "aggs" : {
         "a_count" : { "terms" : { "field" : "a.keyword", "size" : 1000 } }
     }
 }
 '

for((i=1000;i<1500;i++));do curl -XPOST 'localhost:9200/abc/abc/_bulk?pretty' -H 'Content-Type: application/json' -d'
                                                    { "index": { "_id": '$i'1 }}
                                                    { "a" : "naa1", "b" : "nbb1", "c" : 1}
                                                    { "index": { "_id": '$i'2 }}
                                                    { "a" : "naa2", "b" : "nbb2", "c" : 2}
                                                    { "index": { "_id": '$i'3 }}
                                                    { "a" : "naa3", "b" : "nbb3", "c" : 3}
                                                    { "index": { "_id": '$i'4 }}
                                                    { "a" : "naa4", "b" : "nbb4", "c" : 4}
                                                    ';done
