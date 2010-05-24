(ns acl.ch05.ex5-test
  (:use clojure.test
        acl.ch05.ex5))

(deftest test-precedes
  (is (= #{\c \d \r} (precedes "abracadabra" \a))))


