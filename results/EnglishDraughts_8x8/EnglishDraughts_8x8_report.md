# Experiment Report: EnglishDraughts_8x8

*Generated: 2026-08-09 10:49:43*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | EnglishDraughts_8x8 |
| `.lud` game name | English Draughts.lud |
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
| MCVS database key | EnglishDraughts_8x8 (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 3 | 47 | 0 | 50 | 6.0% |
| MAST | 3 | 47 | 0 | 50 | 6.0% |
| RAVE | 0 | 39 | 11 | 50 | 0.0% |
| MCVS | 133 | 6 | 11 | 150 | 88.7% |

| Plies per game | mean = 88.67, min = 34, max = 303 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1515.5 | 998.1 | 1121.2 | 1165.2 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.080 | 0.000 | 0.920 | 998.1 | 1515.5 |
| MAST | MCVS | 25 | 0.000 | 0.000 | 1.000 | 1121.2 | 1515.5 |
| MCVS | UCT | 25 | 0.960 | 0.000 | 0.040 | 1515.5 | 998.1 |
| MCVS | MAST | 25 | 0.880 | 0.000 | 0.120 | 1515.5 | 1121.2 |
| MCVS | RAVE | 25 | 0.680 | 0.320 | 0.000 | 1515.5 | 1165.2 |
| RAVE | MCVS | 25 | 0.000 | 0.120 | 0.880 | 1165.2 | 1515.5 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 107 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 128 |
| 3 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 75 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 47 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 51 |
| 7 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 53 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 55 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 82 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 114 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 53 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 42 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 14 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 63 |
| 15 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 146 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 46 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 52 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 46 |
| 19 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 51 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 48 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 98 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 44 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 50 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 47 |
| 25 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 44 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 43 |
| 27 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 55 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 51 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 48 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 52 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 49 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 46 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 49 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 48 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 46 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 47 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 53 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 79 |
| 39 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 46 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 53 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 54 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 41 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 87 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 75 |
| 45 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 45 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 45 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 68 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 54 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 51 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 75 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 77 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 54 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 55 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 78 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 51 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 129 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 116 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 65 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 55 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 130 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 75 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 47 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 42 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 41 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 53 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 243 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 59 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 49 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 43 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 48 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 48 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 88 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 112 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 49 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 41 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 49 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 53 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 84 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 174 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 43 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 51 |
| 84 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 277 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 71 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 43 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 35 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 48 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 61 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 43 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 44 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 93 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 51 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 71 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 48 |
| 96 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 133 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 52 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 42 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 100 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 48 |
| 101 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 87 |
| 102 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 91 |
| 103 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 50 |
| 104 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 302 |
| 105 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 69 |
| 106 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 48 |
| 107 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 301 |
| 108 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 302 |
| 109 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 50 |
| 110 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 75 |
| 111 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 75 |
| 112 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 302 |
| 113 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 114 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 129 |
| 115 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 160 |
| 116 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 301 |
| 117 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 283 |
| 118 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 73 |
| 119 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 55 |
| 120 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 74 |
| 121 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 72 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 48 |
| 123 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 81 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 98 |
| 125 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 300 |
| 126 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 194 |
| 127 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 88 |
| 128 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 303 |
| 129 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 53 |
| 130 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 51 |
| 131 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 200 |
| 132 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 99 |
| 133 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 100 |
| 134 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 57 |
| 135 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 55 |
| 136 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 302 |
| 137 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 56 |
| 138 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 300 |
| 139 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 49 |
| 140 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 141 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 55 |
| 143 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 300 |
| 144 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 90 |
| 145 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 67 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 147 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 124 |
| 148 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 301 |
| 149 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 150 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 59 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

