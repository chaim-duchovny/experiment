# Experiment Report: Amazons

*Generated: 2026-08-11 19:30:05*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Amazons |
| `.lud` game name | Amazons.lud |
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
| MCVS database key | Amazons (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 1 | 48 | 1 | 50 | 2.0% |
| MAST | 0 | 45 | 5 | 50 | 0.0% |
| RAVE | 1 | 24 | 25 | 50 | 2.0% |
| MCVS | 117 | 2 | 31 | 150 | 78.0% |

| Plies per game | mean = 133.68, min = 88, max = 150 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1450.5 | 995.9 | 1097.6 | 1256.0 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.040 | 0.040 | 0.920 | 995.9 | 1450.5 |
| MAST | MCVS | 25 | 0.000 | 0.120 | 0.880 | 1097.6 | 1450.5 |
| MCVS | UCT | 25 | 1.000 | 0.000 | 0.000 | 1450.5 | 995.9 |
| MCVS | MAST | 25 | 0.920 | 0.080 | 0.000 | 1450.5 | 1097.6 |
| MCVS | RAVE | 25 | 0.520 | 0.480 | 0.000 | 1450.5 | 1256.0 |
| RAVE | MCVS | 25 | 0.040 | 0.520 | 0.440 | 1256.0 | 1450.5 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 136 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 122 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 148 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 110 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 144 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 146 |
| 7 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 142 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 108 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 142 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 120 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 130 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 136 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 126 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 134 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 142 |
| 19 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 136 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 126 |
| 21 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 126 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 118 |
| 23 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 126 |
| 25 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 132 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 126 |
| 27 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 136 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 122 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 108 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 126 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 132 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 130 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 116 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 118 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 124 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 102 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 140 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 130 |
| 39 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 92 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 138 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 142 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 124 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 130 |
| 45 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 116 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 138 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 140 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 142 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 104 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 122 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 132 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 142 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 124 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 110 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 132 |
| 56 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 150 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 144 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 110 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 120 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 142 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 136 |
| 62 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 150 |
| 63 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 130 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 134 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 88 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 114 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 124 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 130 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 112 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 130 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 132 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 150 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 112 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 118 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 134 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 140 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 138 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 132 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 102 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 124 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 114 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 140 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 134 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 140 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 138 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 126 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 128 |
| 92 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 126 |
| 93 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 110 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 144 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 102 |
| 97 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 122 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 116 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 142 |
| 101 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 102 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 103 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 112 |
| 104 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 150 |
| 105 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 148 |
| 106 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 107 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 108 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 109 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 144 |
| 110 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 111 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 108 |
| 112 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 134 |
| 113 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 114 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 115 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 116 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 126 |
| 117 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 144 |
| 118 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 119 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 120 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 146 |
| 121 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 122 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 123 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 138 |
| 125 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 148 |
| 126 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 122 |
| 127 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 128 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 150 |
| 129 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 130 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 131 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 140 |
| 132 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 133 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 132 |
| 134 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 134 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 150 |
| 136 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 138 |
| 137 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 144 |
| 138 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 139 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 140 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 130 |
| 141 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 142 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 144 |
| 144 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 145 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 132 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 146 |
| 147 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 148 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 130 |
| 149 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 150 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 150 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

