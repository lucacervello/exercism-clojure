(ns meetup
  (:require [clj-time.core :as t]
            [clj-time.periodic :as p]
            [clj-time.predicates :as pr]))

(def numbers-teenth
  {:first first
   :second second
   :third #(nth % 2)
   :fourth #(nth % 3)
   :teenth (fn [lst]
             (last (filter #(< 10 (t/day %) 20) lst)))
   :last last})
9
(def weekdays-fn
  {:monday pr/monday?
   :tuesday pr/tuesday?
   :wednesday pr/wednesday?
   :thursday pr/thursday?
   :friday pr/friday?
   :saturday pr/saturday?
   :sunday pr/sunday?})

(defn meetup [month year weekday numbers]
  (let [date-period (into [] (p/periodic-seq (t/date-time year month 1)
                                             (t/plus (t/date-time year month 1) (t/months 1))
                                             (t/days 1)))
        filtered-date (filter (weekday weekdays-fn) date-period)
        date ((numbers numbers-teenth) filtered-date)]
    [(t/year date) (t/month date) (t/day date)]))
