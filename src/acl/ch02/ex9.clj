(ns acl.ch02.ex9)

(defn summit [lst]
  (apply + (filter #(not (nil? %)) lst)))

;; see exo8 for something similar with tail-call optimization
(defn summit2 [lst]
  (if (empty? lst)
    0
    (let [x (first lst)]
      (if (nil? x)
	(summit2 (rest lst))
	(+ x (summit2 (rest lst)))))))
