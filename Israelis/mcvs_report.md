# MCVS Move Statistics

Generated at: 2026-11-23T04:08:08.056687600Z

## Summary (all decisions so far)

| Metric | Value |
|--------|------:|
| Decisions | 29434 |
| Avg simulations (sims) | 745.5 |
| Avg similarity to **win** DB | 0.0463 |
| Avg similarity to **loss** DB | 0.0181 |
| Avg zone score $s_A$ | 0.0271 |

## Notes

- `sims` = number of MCVS PUCT iterations used for the chosen move.
- `simWin` / `simLoss` = max normalized Frobenius similarity of the chosen child matrix $W$ to templates in the win / loss partitions at that depth.
- Detailed per-move rows are in `mcvs_move_stats.csv`.
