(ns etl)
(require '[clojure.string :as string])
(defn transform [v]
  (reduce (fn [all [point votes]]
            (conj all
                  (into {} (map #(vector (string/lower-case %) point) votes))))
          {} v))
