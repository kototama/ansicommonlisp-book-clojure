(ns acl.ch03.ex3-test
  (:use clojure.test
        acl.ch03.ex3))

(deftest test-occurences
  (is (let [occ (occurences '(a b a d a c d c a))]
       (or (= '([a 4] [d 2] [c 2] [b 1]) occ)
           (= '([a 4] [c 2] [d 2] [b 1]) occ)))))


