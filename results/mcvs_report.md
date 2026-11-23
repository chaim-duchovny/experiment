# MCVS Move Statistics

Generated at: 2026-08-14T22:00:28.472658600Z

## Summary (all decisions so far)

| Metric | Value |
|--------|------:|
| Decisions | 23011 |
| Avg simulations (sims) | 40.2 |
| Avg similarity to **win** DB | 0.0004 |
| Avg similarity to **loss** DB | 0.0005 |
| Avg zone score $s_A$ | 0.0001 |

## Notes

- `sims` = number of MCVS PUCT iterations used for the chosen move.
- `simWin` / `simLoss` = max normalized Frobenius similarity of the chosen child matrix $W$ to templates in the win / loss partitions at that depth.
- Detailed per-move rows are in `mcvs_move_stats.csv`.
