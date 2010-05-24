(ns acl.ch05.ex6-test
  (:use clojure.test
        acl.ch05.ex6))

(deftest test-myinterpose
  (= (myinterpose2 \- "abcd") (myinterpose \- "abcd") (interpose \- "abcd")))

