(ns acl.ch03.shortest-path
 (:use clojure.contrib.def))

(declare bfs new-paths)

(defn shortest-path [start end net]
  (bfs end (list (list start)) net))

(defn- bfs [end queue net]
  (if (empty? queue)
    nil
    (let [path (first queue)
	  node (first path)]
      (if (= node end)
	(reverse path)
	(recur end
	       (concat (rest queue)
		       (new-paths path node net))
	       net)))))

(defn- new-paths [path node net]
  (map #(cons % path) (net node)))
