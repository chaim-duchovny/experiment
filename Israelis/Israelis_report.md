# Experiment Report: Israelis

*Generated: 2026-11-23 06:08:08*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Israelis |
| `.lud` game name | C:\Users\User.COMPUTER3\Desktop\Draft\submition\submit\JMLR\paper 2\experiment\mcvs\src\main\java\mcvs\Israelis_v9.lud |
| Game options | (default) |

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
| MCVS database key | Israelis (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 6 | 24 | 20 | 50 | 12.0% |
| MAST | 7 | 23 | 20 | 50 | 14.0% |
| RAVE | 9 | 11 | 30 | 50 | 18.0% |
| MCVS | 58 | 22 | 70 | 150 | 38.7% |

| Plies per game | mean = 440.53, min = 234, max = 500 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1238.8 | 1137.1 | 1176.1 | 1248.0 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.080 | 0.400 | 0.520 | 1137.1 | 1238.8 |
| MAST | MCVS | 25 | 0.160 | 0.520 | 0.320 | 1176.1 | 1238.8 |
| MCVS | UCT | 25 | 0.440 | 0.400 | 0.160 | 1238.8 | 1137.1 |
| MCVS | MAST | 25 | 0.600 | 0.280 | 0.120 | 1238.8 | 1176.1 |
| MCVS | RAVE | 25 | 0.240 | 0.600 | 0.160 | 1238.8 | 1248.0 |
| RAVE | MCVS | 25 | 0.200 | 0.600 | 0.200 | 1248.0 | 1238.8 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 235 |
| 2 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 3 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 371 |
| 5 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 361 |
| 7 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 327 |
| 8 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 492 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 348 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 387 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 376 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 326 |
| 14 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 347 |
| 16 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 332 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 479 |
| 19 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 20 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 246 |
| 22 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 320 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 458 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 357 |
| 26 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 333 |
| 27 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 339 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 248 |
| 30 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 386 |
| 31 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 32 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 33 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 34 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 328 |
| 35 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 36 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 37 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 243 |
| 39 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 500 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 492 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 369 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 499 |
| 44 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 45 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 46 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 466 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 461 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 349 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 348 |
| 50 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 500 |
| 51 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 241 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 358 |
| 53 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 488 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 351 |
| 56 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 500 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 352 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 357 |
| 59 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 497 |
| 61 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 318 |
| 63 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 461 |
| 65 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 490 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 475 |
| 68 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 500 |
| 69 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 470 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 353 |
| 72 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 491 |
| 73 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 74 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 500 |
| 75 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 76 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 500 |
| 77 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 327 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 234 |
| 79 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 80 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 500 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 492 |
| 82 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 500 |
| 83 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 84 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 252 |
| 85 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 346 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 338 |
| 87 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 463 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 365 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 321 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 475 |
| 92 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 382 |
| 93 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 94 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 372 |
| 95 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 451 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 306 |
| 97 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 98 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 500 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 358 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 498 |
| 101 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 102 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 359 |
| 103 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 361 |
| 104 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 496 |
| 106 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 107 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 359 |
| 108 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 109 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 110 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 111 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 458 |
| 112 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 113 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 360 |
| 114 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 115 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 116 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 117 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 118 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 477 |
| 119 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 378 |
| 120 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 373 |
| 121 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 385 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 463 |
| 123 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 372 |
| 125 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 126 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 372 |
| 127 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 128 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 129 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 461 |
| 130 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 131 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 132 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 133 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 337 |
| 134 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 135 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 136 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 137 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 138 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 370 |
| 139 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 140 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 467 |
| 141 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 142 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 499 |
| 143 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 144 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 145 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 485 |
| 146 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 442 |
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

