(ns acl.ch02.ex5-test
  (:use clojure.test
        acl.ch02.ex5))

(deftest test-enigma
  (is (enigma '(a nil c)))
  (is (not (enigma '(a d c))))
  (is (not (enigma '(a (a nil) c)))))

(deftest test-mystery
  (is (= 3 (mystery 'a '( b c d a e))))
  (is (nil? (mystery 'a '( b c d e e)))))


