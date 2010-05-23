(ns acl.ch02.ex3)

(defn fourth [l]
  (first (rest (rest (rest l)))))
