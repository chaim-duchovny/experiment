# Experiment Report: Go9x9_classic

*Generated: 2026-08-12 18:33:09*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Go9x9_classic |
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
| MCVS database key | Go9x9_classic (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 39 | 7 | 4 | 50 | 78.0% |
| MAST | 4 | 44 | 2 | 50 | 8.0% |
| RAVE | 1 | 7 | 42 | 50 | 2.0% |
| MCVS | 58 | 44 | 48 | 150 | 38.7% |

| Plies per game | mean = 112.67, min = 3, max = 150 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1271.7 | 1323.5 | 995.8 | 1209.0 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.840 | 0.040 | 0.120 | 1323.5 | 1271.7 |
| MAST | MCVS | 25 | 0.080 | 0.040 | 0.880 | 995.8 | 1271.7 |
| MCVS | UCT | 25 | 0.160 | 0.120 | 0.720 | 1271.7 | 1323.5 |
| MCVS | MAST | 25 | 0.880 | 0.040 | 0.080 | 1271.7 | 995.8 |
| MCVS | RAVE | 25 | 0.160 | 0.840 | 0.000 | 1271.7 | 1209.0 |
| RAVE | MCVS | 25 | 0.040 | 0.840 | 0.120 | 1209.0 | 1271.7 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 109 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 89 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 101 |
| 4 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 84 |
| 5 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 100 |
| 6 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 90 |
| 7 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 91 |
| 8 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 103 |
| 9 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 127 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 110 |
| 11 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 108 |
| 12 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 114 |
| 13 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 57 |
| 14 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 107 |
| 15 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 104 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 95 |
| 17 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 83 |
| 18 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 78 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 97 |
| 20 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 95 |
| 21 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 103 |
| 22 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 101 |
| 23 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 81 |
| 24 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 117 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 94 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 120 |
| 27 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 71 |
| 28 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 103 |
| 29 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 140 |
| 30 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 114 |
| 31 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 45 |
| 32 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 150 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 108 |
| 34 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 86 |
| 35 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 98 |
| 36 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 74 |
| 37 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 104 |
| 38 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 83 |
| 39 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 36 |
| 40 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 111 |
| 41 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 65 |
| 42 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 103 |
| 43 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 104 |
| 44 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 70 |
| 45 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 113 |
| 46 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 98 |
| 47 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 128 |
| 48 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 98 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 88 |
| 50 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 104 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 74 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 99 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 90 |
| 54 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 71 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 99 |
| 56 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 103 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 112 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 99 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 94 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 91 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 52 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 135 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 80 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 63 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 93 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 96 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 113 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 107 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 81 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 109 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 79 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 112 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 77 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 107 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 89 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 89 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 103 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 107 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 54 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 81 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 112 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 112 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 94 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 136 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 88 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 99 |
| 89 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 81 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 109 |
| 91 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 67 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 102 |
| 93 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 143 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 114 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 150 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 94 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 92 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 111 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 116 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 112 |
| 101 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 102 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 103 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 104 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 110 |
| 105 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 106 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 107 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 108 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 109 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 110 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 111 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 112 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 113 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 114 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 115 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 116 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 102 |
| 117 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 118 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 119 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 120 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 121 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 144 |
| 122 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 123 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 124 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 125 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 3 |
| 126 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 127 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 128 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 129 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 113 |
| 130 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 131 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 132 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 133 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 134 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 135 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 136 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 137 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 138 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 139 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 110 |
| 140 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 141 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 142 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 143 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 144 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 145 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 150 |
| 147 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 148 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 149 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 150 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 133 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

