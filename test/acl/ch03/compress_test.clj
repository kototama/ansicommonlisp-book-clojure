(ns acl.ch03.compress-test
  (:use clojure.test
        acl.ch03.compress))

(deftest test-compress
  (is (= '((3 1) 0 1 (4 0) 1) (compress '(1 1 1 0 1 0 0 0 0 1)))))

(deftest test-uncompress
  (is (= '(1 1 1 0 1 0 0 0 0 1) (uncompress '((3 1) 0 1 (4 0) 1)))))

