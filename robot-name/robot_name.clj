(ns robot-name)

(def char-vec  (map char (range 65 91)))

(def name (atom ""))

(defn robot []
  (swap! name (fn [_] (str (apply str (repeatedly 2 #(rand-nth char-vec)))
                           (apply str (repeatedly 3 #(rand-int 10)))))))

(defn robot-name [nam]
  nam)

(defn reset-name [_]
  (robot))
