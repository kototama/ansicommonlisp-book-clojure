(ns acl.ch06.ex2-test
  (:use clojure.test
        acl.ch06.ex2))

(deftest test-binsearch
  (is (nil? (binsearch [1 2 3 4 5 6] 9)))
  (is (= 6 (binsearch [0 1 2 3 4 5 6 7 8 9] 6)))
  (is (= [6 :six]
           (binsearch [ [0 :zero] [1 :one] [2 :two] [3 :three] [4 :four]
                        [5 :five] [6 :six] [7 :seven] [8 :eight] [9 :nine]]
                      6 {:test = :key first :start 0 :end 9} ))))
