(ns acl.ch04.ex4-test
  (:use clojure.test
        acl.ch04.ex5
        acl.ch04.bst))

(deftest test-bst-adjoin
  (let [bst (reduce (fn [acc x] (bst-insert acc x <)) nil [5 8 4 2 1 9 6 7 3])]
    (is (= (bst-adjoin nums 8 <) (bst-insert nums 8 <)))))
