(ns acl.ch02.ex7-test
  (:use clojure.test
        acl.ch02.ex7))

(deftest test-contains-list?
  (is (not (contains-list? '(a b c))))
  (is (not (contains-list? nil)))
  (is (not (contains-list? '(a nil c))))
  (is (contains-list? '(a '(aa bb) c))))



