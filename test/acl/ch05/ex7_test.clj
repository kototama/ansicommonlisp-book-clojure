(ns acl.ch05.ex7-test
  (:use clojure.test
        acl.ch05.ex7))

(deftest test-continuous-pairs?
  (is (continuous-pairs? [1 2 -2 -3 -3 -2 7 6]))
  (is (not (continuous-pairs? [1 2 -2 -2 -3 -2 7 6]))))

