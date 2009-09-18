(defn summit [lst]
  (apply + (filter #(not (nil? %)) lst)))


(summit '(1 2 3 4)) ;; 10
(summit nil) ;; 0
(summit '(1 2 nil 4)) ;; 7

