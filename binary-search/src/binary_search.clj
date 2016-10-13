(ns binary-search)

(defn middle [lst]
  (-> lst
      count
      (quot 2)))

(defn search-for [key lst]
  (loop [l lst
         index 0]
    (let [mid (middle l)]
      (cond
        (= key (nth l mid)) (+ index mid)
        (= 0 mid) (throw (Exception. "not found"))
        (> key (nth l mid)) (recur (drop mid l) (+ index mid))
        :else (recur (take mid l) index)))))
