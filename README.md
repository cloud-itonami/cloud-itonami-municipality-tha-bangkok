# cloud-itonami-municipality-tha-bangkok

Municipal-ordinance compliance catalog for **Bangkok** — the
THIRTY-FIRST municipality-level entry alongside
[`cloud-itonami-municipality-jpn-tokyo`](https://github.com/cloud-itonami/cloud-itonami-municipality-jpn-tokyo),
[`cloud-itonami-municipality-usa-washington-dc`](https://github.com/cloud-itonami/cloud-itonami-municipality-usa-washington-dc),
[`cloud-itonami-municipality-gbr-london`](https://github.com/cloud-itonami/cloud-itonami-municipality-gbr-london),
[`cloud-itonami-municipality-can-toronto`](https://github.com/cloud-itonami/cloud-itonami-municipality-can-toronto),
[`cloud-itonami-municipality-deu-berlin`](https://github.com/cloud-itonami/cloud-itonami-municipality-deu-berlin),
[`cloud-itonami-municipality-fra-paris`](https://github.com/cloud-itonami/cloud-itonami-municipality-fra-paris),
[`cloud-itonami-municipality-nld-amsterdam`](https://github.com/cloud-itonami/cloud-itonami-municipality-nld-amsterdam),
[`cloud-itonami-municipality-esp-madrid`](https://github.com/cloud-itonami/cloud-itonami-municipality-esp-madrid),
[`cloud-itonami-municipality-kor-seoul`](https://github.com/cloud-itonami/cloud-itonami-municipality-kor-seoul),
[`cloud-itonami-municipality-ita-roma`](https://github.com/cloud-itonami/cloud-itonami-municipality-ita-roma),
[`cloud-itonami-municipality-aus-sydney`](https://github.com/cloud-itonami/cloud-itonami-municipality-aus-sydney),
[`cloud-itonami-municipality-arg-buenos-aires`](https://github.com/cloud-itonami/cloud-itonami-municipality-arg-buenos-aires),
[`cloud-itonami-municipality-fin-helsinki`](https://github.com/cloud-itonami/cloud-itonami-municipality-fin-helsinki),
[`cloud-itonami-municipality-dnk-copenhagen`](https://github.com/cloud-itonami/cloud-itonami-municipality-dnk-copenhagen),
[`cloud-itonami-municipality-nor-oslo`](https://github.com/cloud-itonami/cloud-itonami-municipality-nor-oslo),
[`cloud-itonami-municipality-bel-brussels`](https://github.com/cloud-itonami/cloud-itonami-municipality-bel-brussels),
[`cloud-itonami-municipality-chl-santiago`](https://github.com/cloud-itonami/cloud-itonami-municipality-chl-santiago),
[`cloud-itonami-municipality-col-bogota`](https://github.com/cloud-itonami/cloud-itonami-municipality-col-bogota),
[`cloud-itonami-municipality-cri-san-jose`](https://github.com/cloud-itonami/cloud-itonami-municipality-cri-san-jose),
[`cloud-itonami-municipality-bra-sao-paulo`](https://github.com/cloud-itonami/cloud-itonami-municipality-bra-sao-paulo),
[`cloud-itonami-municipality-ury-montevideo`](https://github.com/cloud-itonami/cloud-itonami-municipality-ury-montevideo),
[`cloud-itonami-municipality-zaf-cape-town`](https://github.com/cloud-itonami/cloud-itonami-municipality-zaf-cape-town),
[`cloud-itonami-municipality-ecu-quito`](https://github.com/cloud-itonami/cloud-itonami-municipality-ecu-quito),
[`cloud-itonami-municipality-swe-gothenburg`](https://github.com/cloud-itonami/cloud-itonami-municipality-swe-gothenburg),
[`cloud-itonami-municipality-pry-asuncion`](https://github.com/cloud-itonami/cloud-itonami-municipality-pry-asuncion),
[`cloud-itonami-municipality-mex-guadalajara`](https://github.com/cloud-itonami/cloud-itonami-municipality-mex-guadalajara),
[`cloud-itonami-municipality-fra-lyon`](https://github.com/cloud-itonami/cloud-itonami-municipality-fra-lyon),
[`cloud-itonami-municipality-ind-new-delhi`](https://github.com/cloud-itonami/cloud-itonami-municipality-ind-new-delhi),
[`cloud-itonami-municipality-pol-warsaw`](https://github.com/cloud-itonami/cloud-itonami-municipality-pol-warsaw),
and
[`cloud-itonami-municipality-ken-nairobi`](https://github.com/cloud-itonami/cloud-itonami-municipality-ken-nairobi).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

Bangkok is the axis's first Southeast Asian entry.

## Sourcing note

`official.bangkok.go.th`'s own About page returned HTTP 403. Both
entries here instead cite two working domains: `en.wikisource.org`
(a Wikimedia project hosting a verbatim English translation of the
Royal Gazette text of the 1985 Act) and `bmc.go.th` (the Bangkok
Metropolitan Council's own site, a different official domain than
the blocked one).

A Wikisource page titled
`Translation:Bangkok_Metropolitan_Administration_Act,_BE_2528_(1985)/2007.08.01`
turned out, on reading, to actually be the text of a LATER 1991
amendment despite its URL/title referencing the 1985 original — a
wrong-document mismatch caught by checking the fetched content's own
stated title/date against what was expected. The correct original Act
was instead found at the (differently-URLed) main Wikisource page.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on the Bangkok
Metropolitan Administration's behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljc` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries directly confirmed: **Administrative Organisation of
Bangkok Metropolitan Administration Act, 2528 BE** (20 August 1985)
and the **Bangkok Metropolitan Council's founding** (Declaration No.
335 of the Revolution Committee, 13 December 1972).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Ordinance text
itself remains the Bangkok Metropolitan Administration's; this repo
stores only citation metadata (id/title/url/dates), not full text.
