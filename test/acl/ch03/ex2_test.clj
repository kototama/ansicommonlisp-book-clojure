(ns acl.ch03.ex2-test
  (:use clojure.test
        acl.ch03.ex2))

(deftest test-stable-union
  (is (= '(:a :b :c :d) (stable-union '(:a :b :c) '(:b :a :d)))))
