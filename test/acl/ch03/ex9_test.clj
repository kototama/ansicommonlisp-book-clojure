(ns acl.ch03.ex9-test
  (:use clojure.test
        acl.ch03.ex9))

(deftest test-longest-path
  (is (= '(a b c d) (longest-path 'a 'd { 'a '(b c), 'b '(c), 'c '(d)})))
  (is (= '(a b c d e)
         (longest-path 'a 'e
                       {'a '(b f), 'b '(c), 'c '(d),
                        'd '(b e), 'f '(e), 'e '()})))
  (is (empty? (longest-path 'd 'f {'a '(b f), 'b '(c), 'c '(d), 'd '(b e), 'f
                                   '(e), 'e '()})))
  (is (= '(a b1 c1 d2 c2 c3 e1)
         (longest-path 'a 'e1 {'a '(b1 b2), 'b1 '(c1 c2), 'c1 '(d1 d2),
                               'd2 '(e1 c2), 'c2 '(e1 c3), 'c3 '(e1)} )))
  (is (empty? (longest-path 'x 'y {}))))

