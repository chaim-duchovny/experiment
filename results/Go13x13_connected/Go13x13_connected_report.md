# Experiment Report: Go13x13_connected

*Generated: 2026-08-15 01:00:28*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Go13x13_connected |
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
| MCVS database key | Go13x13_connected (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 41 | 7 | 2 | 50 | 82.0% |
| MAST | 24 | 23 | 3 | 50 | 48.0% |
| RAVE | 0 | 7 | 43 | 50 | 0.0% |
| MCVS | 37 | 65 | 48 | 150 | 24.7% |

| Plies per game | mean = 316.83, min = 123, max = 500 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1169.0 | 1344.3 | 1161.8 | 1124.9 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.760 | 0.040 | 0.200 | 1344.3 | 1169.0 |
| MAST | MCVS | 25 | 0.600 | 0.040 | 0.360 | 1161.8 | 1169.0 |
| MCVS | UCT | 25 | 0.080 | 0.040 | 0.880 | 1169.0 | 1344.3 |
| MCVS | MAST | 25 | 0.560 | 0.080 | 0.360 | 1169.0 | 1161.8 |
| MCVS | RAVE | 25 | 0.200 | 0.800 | 0.000 | 1169.0 | 1124.9 |
| RAVE | MCVS | 25 | 0.000 | 0.920 | 0.080 | 1124.9 | 1169.0 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 219 |
| 2 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 192 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 172 |
| 4 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 176 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 182 |
| 6 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 282 |
| 7 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 197 |
| 8 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 179 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 180 |
| 10 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 268 |
| 11 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 192 |
| 12 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 186 |
| 13 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 163 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 182 |
| 16 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 264 |
| 17 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 321 |
| 18 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 286 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 303 |
| 20 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 308 |
| 21 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 194 |
| 22 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 275 |
| 23 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 291 |
| 24 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 198 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 179 |
| 26 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 271 |
| 27 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 200 |
| 28 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 188 |
| 29 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 161 |
| 30 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 310 |
| 31 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 235 |
| 32 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 198 |
| 33 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 293 |
| 34 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 191 |
| 35 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 278 |
| 36 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 188 |
| 37 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 177 |
| 38 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 182 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 195 |
| 40 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 250 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 170 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 151 |
| 43 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 174 |
| 44 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 176 |
| 45 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 313 |
| 46 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 198 |
| 47 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 218 |
| 48 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 280 |
| 49 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 181 |
| 50 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 187 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 190 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 198 |
| 54 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 287 |
| 55 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 290 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 228 |
| 57 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 312 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 204 |
| 59 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 203 |
| 60 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 268 |
| 61 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 319 |
| 63 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 255 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 177 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 458 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 180 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 205 |
| 68 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 332 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 206 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 189 |
| 71 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 202 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 199 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 184 |
| 74 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 214 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 215 |
| 76 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 324 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 162 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 211 |
| 79 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 206 |
| 80 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 351 |
| 81 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 186 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 208 |
| 83 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 282 |
| 84 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 181 |
| 85 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 326 |
| 86 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 161 |
| 87 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 374 |
| 88 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 474 |
| 89 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 330 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 211 |
| 91 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 321 |
| 92 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 172 |
| 93 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 187 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 159 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 215 |
| 96 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 182 |
| 97 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 331 |
| 98 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 312 |
| 99 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 303 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 211 |
| 101 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 102 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 103 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 104 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 105 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 106 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 401 |
| 107 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 108 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 109 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 110 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 111 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 459 |
| 112 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 113 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 114 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 115 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 116 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 320 |
| 117 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 118 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 119 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 120 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 121 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 327 |
| 123 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 124 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 125 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 126 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 127 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 128 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 129 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 130 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 131 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 132 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 123 |
| 133 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 134 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 135 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 136 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 137 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 138 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 139 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 140 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 141 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 142 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 301 |
| 144 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 500 |
| 145 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 500 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 316 |
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

