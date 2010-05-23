(ns acl.ch02.ex8-test
  (:use clojure.test
        acl.ch02.ex8))

(deftest test-count-a
  (is (zero? (count-a nil)))
  (is (= 3 (count-a '(a a a))))
  (is (zero? (count-a '(oo ll ee)))))
