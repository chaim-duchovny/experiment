# Experiment Report: Go9x9_connected

*Generated: 2026-08-12 23:15:04*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Go9x9_connected |
| `.lud` game name | Go.lud |
| Game options | Board Size/9x9 |

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
| MCVS database key | Go9x9_connected (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 37 | 9 | 4 | 50 | 74.0% |
| MAST | 7 | 42 | 1 | 50 | 14.0% |
| RAVE | 0 | 8 | 42 | 50 | 0.0% |
| MCVS | 59 | 44 | 47 | 150 | 39.3% |

| Plies per game | mean = 111.28, min = 3, max = 150 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1274.0 | 1295.8 | 1018.8 | 1211.4 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.760 | 0.000 | 0.240 | 1295.8 | 1274.0 |
| MAST | MCVS | 25 | 0.160 | 0.040 | 0.800 | 1018.8 | 1274.0 |
| MCVS | UCT | 25 | 0.120 | 0.160 | 0.720 | 1274.0 | 1295.8 |
| MCVS | MAST | 25 | 0.880 | 0.000 | 0.120 | 1274.0 | 1018.8 |
| MCVS | RAVE | 25 | 0.200 | 0.800 | 0.000 | 1274.0 | 1211.4 |
| RAVE | MCVS | 25 | 0.000 | 0.880 | 0.120 | 1211.4 | 1274.0 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 127 |
| 2 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 96 |
| 3 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 117 |
| 4 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 110 |
| 5 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 3 |
| 6 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 108 |
| 7 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 89 |
| 8 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 94 |
| 9 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 92 |
| 10 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 114 |
| 11 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 125 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 124 |
| 13 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 107 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 79 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 82 |
| 16 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 78 |
| 17 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 121 |
| 18 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 83 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 73 |
| 20 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 102 |
| 21 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 90 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 35 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 92 |
| 24 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 78 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 55 |
| 26 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 7 |
| 27 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 108 |
| 28 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 116 |
| 29 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 114 |
| 30 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 93 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 88 |
| 32 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 5 |
| 33 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 143 |
| 34 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 58 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 95 |
| 36 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 74 |
| 37 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 124 |
| 38 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 140 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 123 |
| 40 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 123 |
| 41 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 93 |
| 42 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 80 |
| 43 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 85 |
| 44 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 105 |
| 45 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 52 |
| 46 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 113 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 114 |
| 48 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 134 |
| 49 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 110 |
| 50 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 7 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 102 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 111 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 114 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 106 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 95 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 102 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 70 |
| 58 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 90 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 96 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 93 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 138 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 104 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 117 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 78 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 107 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 127 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 130 |
| 68 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 60 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 94 |
| 70 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 80 |
| 71 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 104 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 125 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 103 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 105 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 92 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 83 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 104 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 88 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 84 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 3 |
| 81 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 121 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 89 |
| 83 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 107 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 103 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 104 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 87 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 124 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 101 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 114 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 127 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 86 |
| 92 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 75 |
| 93 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 100 |
| 95 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 139 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 100 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 93 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 41 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 104 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 3 |
| 101 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 102 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 103 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 104 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 105 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 106 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 107 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 108 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 108 |
| 109 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 110 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 111 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 112 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 113 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 114 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 127 |
| 115 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 116 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 117 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 132 |
| 118 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 101 |
| 119 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 120 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 121 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 122 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 123 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 124 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 125 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 126 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 127 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 128 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 104 |
| 129 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 130 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 131 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 148 |
| 132 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 133 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 134 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 135 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 136 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 137 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 138 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 139 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 140 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 141 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 142 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 143 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 144 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 145 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 121 |
| 146 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 147 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 148 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 149 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 150 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 100 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

