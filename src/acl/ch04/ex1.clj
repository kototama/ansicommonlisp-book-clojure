(ns acl.ch04.ex1)

(defn rotate [m]
  (apply vector (apply map (fn [& args] (apply vector (reverse args))) m)))

(defn rotate-seq [m]
  "rotate vector m, returns a lazy sequence of lazy sequences"
  (apply map (comp reverse vector) m))
