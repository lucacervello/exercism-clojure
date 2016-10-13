(ns meetup)
(require '[clj-time.core :as time])
(require '[clj-time.periodic :as time-period])
(require '[clj-time.predicates :as pr])

(defn time-range
  "Return a lazy sequence of DateTime's from start to end, incremented
  by 'step' units of time."
  [start end step]
  (let [inf-range (time-period/periodic-seq start step)
        below-end? (fn [t] (time/within? (time/interval start end)
                                         t))]
    (take-while below-end? inf-range)))

(defn beauty-output [datetime]
  (vector (time/year datetime)
          (time/month datetime)
          (time/day datetime)))

(defn meetup [month year week-day n]
  (let [date (time/date-time year month)
        all-month (time-range date
                              (time/plus date (time/months 1))
                              (time/days 1))
        sub-res (filter (resolve (symbol (str "pr/" (name week-day) "?")))
                        all-month)]
    (case n
      :first (beauty-output (first sub-res))
      :second (beauty-output (second sub-res))
      :third (beauty-output (nth sub-res 2))
      :fourth (beauty-output (nth sub-res 3))
      :last (beauty-output (last sub-res))
      ;:teenth sub-res)))
      :teenth (beauty-output (first (filter #(< 13 (time/days %) 20) sub-res))))))
