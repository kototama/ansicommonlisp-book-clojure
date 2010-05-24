(ns acl.ch06.ex4-test
  (:use clojure.test
        acl.ch06.ex4))

(deftest test-most
  (is (= [-3 nil] (most [-3])))
  (is (= [42 41] (most [41 42])))
  (is (= [6 5] (most [1 2 3 4 5 6])))
  (is (= [-1 -2] (most [-1 -2 -3 -4 -5 -6]))))

(deftest test-most-with-func
  (letfn [(negate [x] (if (nil? x) nil (- x)))]
    (is (= [3 nil] (most negate [-3])))
    (is (= [-41 -42] (most negate [41 42])))
    (is (= [-1 -2] (most negate [1 2 3 4 5 6])))
    (is (= [6 5] (most negate [-1 -2 -3 -4 -5 -6])))))
