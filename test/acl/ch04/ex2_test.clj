(ns acl.ch04.ex2-test
  (:use clojure.test
        acl.ch04.ex2))

(deftest test-my-reverse
   (is (= (my-reverse '(:a :b :c)) '(:c :b :a))))
