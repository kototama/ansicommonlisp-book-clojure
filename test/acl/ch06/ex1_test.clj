(ns acl.ch06.ex1-test
  (:use clojure.test
        acl.ch06.ex1))

(deftest test-tokens
  (is (= '("ab12" "3cde.f") (tokens "ab12 3cde.f" )))
  (is (= '("ab" "cde" "f") (tokens "ab12 3cde.f" {:regex #"[a-zA-Z]+"}))))


