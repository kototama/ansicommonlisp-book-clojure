(ns acl.ch04.ex1-test
  (:use clojure.test
        acl.ch04.ex1))

(deftest test-rotate
  (is (= [[:c :a] [:d :b]] (rotate [[:a :b] [:c :d]])))
  (is (= [[:g :d :a] [:h :e :b] [:i :f :c]]
           (rotate [[:a :b :c] [:d :e :f] [:g :h :i]]))))

(deftest test-rotate-seq
  (is (= [[:g :d :a] [:h :e :b] [:i :f :c]]
           (rotate [[:a :b :c] [:d :e :f] [:g :h :i]]))))
