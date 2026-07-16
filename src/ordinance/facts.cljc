(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Bangkok -- the
  THIRTY-FIRST municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara, -fra-lyon,
  -ind-new-delhi, -pol-warsaw, -ken-nairobi for the first thirty) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation). The
  axis's first Southeast Asian entry.

  official.bangkok.go.th's own About page returned HTTP 403. Both
  entries here instead cite two working domains: en.wikisource.org
  (a Wikimedia project hosting a verbatim English translation of the
  Royal Gazette text of the 1985 Act) and bmc.go.th (the Bangkok
  Metropolitan Council's own site, a different official domain than
  the blocked one) for the Council's own 1972 founding declaration.

  A Wikisource page titled 'Translation:Bangkok_Metropolitan_
  Administration_Act,_BE_2528_(1985)/2007.08.01' turned out, on
  reading, to actually be the TEXT OF A LATER 1991 AMENDMENT ('Act
  (No 2), 2534 BE') despite its URL/title referencing the 1985
  original -- a wrong-document mismatch caught by checking the
  fetched content's own stated title/date against what was expected,
  per this project's established discipline. The correct original Act
  was instead found at the (differently-URLed) main Wikisource page.

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"bangkok"
   [{:ordinance/id "bangkok.administrative-organisation-act-2528"
     :ordinance/title "Administrative Organisation of Bangkok Metropolitan Administration Act, 2528 BE"
     :ordinance/municipality "bangkok"
     :ordinance/country "THA"
     :ordinance/kind :local-act
     :ordinance/number "2528 BE"
     :ordinance/url "https://en.wikisource.org/wiki/Bangkok_Metropolitan_Administration_Act,_BE_2528_(1985)"
     :ordinance/url-provenance :official-wikisource-mirror
     :ordinance/enacted-date "1985-08-20"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}
    {:ordinance/id "bangkok.metropolitan-council-founding-1972"
     :ordinance/title "Bangkok Metropolitan Council founding (Declaration No. 335 of the Revolution Committee)"
     :ordinance/municipality "bangkok"
     :ordinance/country "THA"
     :ordinance/kind :local-act
     :ordinance/number "Declaration No. 335"
     :ordinance/url "https://bmc.go.th/en/history/"
     :ordinance/url-provenance :official-bmc-go-th
     :ordinance/enacted-date "1972-12-13"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-tha-bangkok Wave 0 (ADR-2607141700): "
                 (count (get catalog "bangkok")) " Bangkok entries seeded "
                 "with official wikisource.org/bmc.go.th citations. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
