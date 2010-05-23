(ns acl.ch02.ex3-test
  (:use clojure.test
        acl.ch02.ex3))

(deftest test-fourth
  (is (nil? (fourth nil)))
  (is (nil? (fourth [1 2 3])))
  (is (= 4 (fourth [1 2 3 4])))
  (is (= 'd (fourth '(a nil c d e f)))
  (is (= '(aa bb) (fourth '(a b c (aa bb) d))))))
