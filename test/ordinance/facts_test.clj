(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest bangkok-has-spec-basis
  (let [sb (facts/spec-basis "bangkok")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://") sb))
    (is (every? :ordinance/number sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "chiang-mai")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["bangkok" "chiang-mai"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["chiang-mai"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "bangkok" :governance))))
  (is (empty? (facts/by-topic "bangkok" :labor)))
  (is (empty? (facts/by-topic "chiang-mai" :governance))))
