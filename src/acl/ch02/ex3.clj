(defn fourth [l]
  (first (rest (rest (rest l)))))


(fourth nil) ;; nil
(fourth '(1 2 3)) ;; nil
(fourth '(1 2 3 4)) ;; 4
(fourth '(a nil c d e f)) ;; d
(fourth '(a b c (aa bb) d)) ;; (AA BB)


