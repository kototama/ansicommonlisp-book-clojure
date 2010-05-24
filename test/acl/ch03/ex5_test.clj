(ns acl.ch03.ex5-test
  (:use clojure.test
        acl.ch03.ex5))

(deftest test-pos+
  (is (= '(7 6 3 7) (pos+ [7 5 1 4]))))

(deftest test-pos+2
  (is (= '(7 6 3 7) (pos+2 [7 5 1 4]))))