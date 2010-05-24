(ns acl.ch04.bst-test
  (:use clojure.test
        clojure.contrib.def
        acl.ch04.bst))

(defvar- nums (reduce (fn [acc x] (bst-insert acc x <)) nil [5 8 4 2 1 9 6 7 3]))

(deftest test-bst
  (let [nums2 (reduce (fn [acc x] (bst-insert-tc acc x <)) nil
                      [5 8 4 2 1 9 6 7 3])
        nums3 (reduce (fn [acc x] (bst-insert-tc2 acc x <)) nil
                      [5 8 4 2 1 9 6 7 3])
        nums4 (reduce (fn [acc x] (bst-insert-tc3 acc x <)) nil
                      [5 8 4 2 1 9 6 7 3])]
    (is (= nums nums2 nums3 nums4))
    (is (nil? (bst-find nums 12 <)))
    (is (= {:elt 4, :l {:elt 2, :l {:elt 1, :l nil, :r nil},
                        :r {:elt 3, :l nil, :r nil}}, :r nil}
           (bst-find nums 4 <)))))

(deftest test-bst-min
  (is (= {:elt 1, :l nil, :r nil} (bst-min nums))))

(deftest test-bst-max
  (is (= {:elt 9, :l nil, :r nil} (bst-max nums))))

;; (bst-traverse (bst-remove nums 2 <) print) ; 13456789

(deftest test-bst-remove
 ;; test against the errata code for bst-remove
 ;; see http://codangaems.blogspot.com/2008/01/ansi-common-lisp-and-bst-remove.html
 ;; and http://www.paulgraham.com/ancomliser.html

  (let [simple (reduce (fn [acc x] (bst-insert acc x <)) nil [5 2 1 3])
        invalidtree {:elt 3, :l {:elt 1, :l nil, :r nil}, :r nil}] 
    (dotimes [_ 10000]
      (is (not= (bst-remove (bst-remove simple 2 <) 5 <) invalidtree)))))
