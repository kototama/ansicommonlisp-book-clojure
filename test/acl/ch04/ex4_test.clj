(ns acl.ch04.ex4-test
  (:use clojure.test
        acl.ch04.ex4
        acl.ch04.bst))

(deftest test-bst-list
  (let [bst (reduce (fn [acc x] (bst-insert acc x <)) nil [5 8 4 2 1 9 6 7 3])]
   (is (= '(9 8 7 6 5 4 3 2 1) (bst-list bst)))))


