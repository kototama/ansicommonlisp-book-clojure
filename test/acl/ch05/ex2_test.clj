(ns acl.ch05.ex2-test
  (:use clojure.test
        acl.ch05.ex2))

(deftest test-mystery
  (is (= 3 (mystery :a [:b :c :d :a :e])))
  (is (nil? (mystery :a  [:b :c :d :e :e]))))

(deftest test-mystery2
  (is (= (mystery2 :a [:b :c :d :a :e]) (mystery :a [:b :c :d :a :e])))
  (is (= (mystery2 :a  [:b :c :d :e :e]) (mystery :a [:b :c :d :e :e]))))

