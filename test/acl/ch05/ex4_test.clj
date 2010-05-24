(ns acl.ch05.ex4-test
  (:use clojure.test
        acl.ch05.ex4))

(deftest test-month-num2
  (is (= (month-num2 1 2000) (month-num 1 2000)))
  (is (= (month-num2 12 2004) (month-num 12 2004))))
