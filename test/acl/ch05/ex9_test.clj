(ns acl.ch05.ex9-test
  (:use clojure.test
        acl.ch05.ex9))

(deftest test-shortest-path
  (let [minnet { 'a '(b c), 'b '(c), 'c '(d)}]
    (is (= '(a c d) (shortest-path 'a 'd minnet)))))

