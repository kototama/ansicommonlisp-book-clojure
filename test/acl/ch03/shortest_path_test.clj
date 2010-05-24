(ns acl.ch03.shortest-path-test
  (:use clojure.test
        acl.ch03.shortest-path))

(deftest test-shortest-path
  (is (= '(a c d) (shortest-path 'a 'd { 'a '(b c), 'b '(c), 'c '(d)}))))

