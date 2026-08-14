# Experiment Report: Go13x13_classic

*Generated: 2026-08-14 00:00:58*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Go13x13_classic |
| `.lud` game name | Go.lud |
| Game options | Board Size/13x13 |

## 2. Agents / Search Algorithms Compared

| Agent | Role |
|---|---|
| UCT | Baseline |
| MAST | Baseline |
| RAVE | Baseline |
| MCVS | Proposed method (Monte Carlo Vector Search) |

## 3. Search Budget and Experimental Hyperparameters

| Parameter | Value |
|---|---|
| Thinking time per move (s) | 1.000 |
| Max iterations per move | unbounded / not used |
| Games per pairing (per colour) | 25 |
| Opponents faced by MCVS | UCT, MAST, RAVE |
| Total games played (this variant) | 150 |
| Elo K-factor | 24.0 |
| MCVS database key | Go13x13_classic (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 42 | 6 | 2 | 50 | 84.0% |
| MAST | 12 | 38 | 0 | 50 | 24.0% |
| RAVE | 1 | 16 | 33 | 50 | 2.0% |
| MCVS | 60 | 55 | 35 | 150 | 40.0% |

| Plies per game | mean = 309.59, min = 3, max = 500 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1211.1 | 1363.2 | 1059.1 | 1166.6 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.840 | 0.040 | 0.120 | 1363.2 | 1211.1 |
| MAST | MCVS | 25 | 0.160 | 0.000 | 0.840 | 1059.1 | 1211.1 |
| MCVS | UCT | 25 | 0.120 | 0.040 | 0.840 | 1211.1 | 1363.2 |
| MCVS | MAST | 25 | 0.680 | 0.000 | 0.320 | 1211.1 | 1059.1 |
| MCVS | RAVE | 25 | 0.320 | 0.640 | 0.040 | 1211.1 | 1166.6 |
| RAVE | MCVS | 25 | 0.000 | 0.680 | 0.320 | 1166.6 | 1211.1 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 181 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 159 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 166 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 73 |
| 5 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 277 |
| 6 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 159 |
| 7 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 329 |
| 8 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 298 |
| 9 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 213 |
| 10 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 262 |
| 11 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 259 |
| 12 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 307 |
| 13 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 219 |
| 14 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 234 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 208 |
| 16 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 214 |
| 17 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 303 |
| 18 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 332 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 228 |
| 20 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 278 |
| 21 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 328 |
| 22 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 216 |
| 23 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 207 |
| 24 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 296 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 278 |
| 26 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 201 |
| 27 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 185 |
| 28 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 284 |
| 29 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 351 |
| 30 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 224 |
| 31 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 14 |
| 32 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 284 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 222 |
| 34 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 212 |
| 35 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 223 |
| 36 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 240 |
| 37 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 347 |
| 38 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 198 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 225 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 159 |
| 41 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 184 |
| 42 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 289 |
| 43 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 177 |
| 44 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 336 |
| 45 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 301 |
| 46 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 278 |
| 47 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 290 |
| 48 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 292 |
| 49 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 279 |
| 50 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 198 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 303 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 239 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 214 |
| 54 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 335 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 241 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 327 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 222 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 3 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 190 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 318 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 180 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 319 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 206 |
| 64 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 284 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 200 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 335 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 160 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 222 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 151 |
| 70 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 335 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 168 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 241 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 325 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 175 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 200 |
| 76 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 378 |
| 77 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 286 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 206 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 344 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 236 |
| 81 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 270 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 252 |
| 83 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 275 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 217 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 162 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 232 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 232 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 305 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 184 |
| 90 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 195 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 222 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 343 |
| 93 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 148 |
| 94 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 332 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 168 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 157 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 166 |
| 98 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 318 |
| 99 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 245 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 187 |
| 101 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 102 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 401 |
| 103 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 229 |
| 104 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 105 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 106 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 107 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 108 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 405 |
| 109 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 370 |
| 110 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 216 |
| 111 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 474 |
| 112 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 240 |
| 113 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 114 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 115 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 352 |
| 116 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 117 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 408 |
| 118 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 119 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 120 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 121 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 441 |
| 123 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 400 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 335 |
| 125 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 126 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 127 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 128 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 129 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 130 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 131 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 132 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 335 |
| 133 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 134 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 135 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 136 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 428 |
| 137 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 230 |
| 138 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 139 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 140 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 141 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 424 |
| 142 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 143 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 144 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 145 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 146 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 280 |
| 147 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 148 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 149 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 150 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

