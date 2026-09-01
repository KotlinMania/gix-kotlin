# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 28/176 (15.9%)
- **Function parity:** 17/1132 matched (target 91) — 1.5%
- **Class/type parity:** 22/288 matched (target 142) — 7.6%
- **Combined symbol parity:** 39/1420 matched (target 233) — 2.7%
- **Average inline-code cosine:** 0.26 (function body across 25 matched files)
- **Average documentation cosine:** 0.45 (doc text across 25 matched files)
- **Cheat-zeroed Files:** 10
- **Critical Issues:** 23 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

### 1. parse.error
- **Similarity:** 0.00 (needs 85% improvement)
- **Dependencies:** 22
- **Priority Score:** 22030410.0
- **Functions:** 0/2 matched (target 1)
- **Missing functions:** `fmt`, `ambiguous`
- **Types:** 1/2 matched (target 5)
- **Missing types:** `Order`
- **Symbol Deficit:** 3 (functions: 2, types: 1)
- **Action:** Deep review - likely missing major functionality

### 2. ext.object_id
- **Similarity:** 0.00 (needs 85% improvement)
- **Dependencies:** 17
- **Priority Score:** 17040510.0
- **Functions:** 1/2 matched
- **Missing functions:** `ancestors`
- **Types:** 0/3 matched (target 1)
- **Missing types:** `Sealed`, `AncestorsIter`, `ObjectIdExt`
- **Symbol Deficit:** 4 (functions: 1, types: 3)
- **Action:** Deep review - likely missing major functionality

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. parse.error

- **Target:** `parse.Error`
- **Similarity:** 0.00
- **Dependents:** 22
- **Priority Score:** 22030410.0
- **Functions:** 0/2 matched (target 1)
- **Missing functions:** `fmt`, `ambiguous`
- **Types:** 1/2 matched (target 5)
- **Missing types:** `Order`

### 2. ext.object_id

- **Target:** `ext.ObjectId [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 17
- **Priority Score:** 17040510.0
- **Functions:** 1/2 matched
- **Missing functions:** `ancestors`
- **Types:** 0/3 matched (target 1)
- **Missing types:** `Sealed`, `AncestorsIter`, `ObjectIdExt`

### 3. ext.tree

- **Target:** `ext.Tree`
- **Similarity:** 0.51
- **Dependents:** 5
- **Priority Score:** 5060705.0
- **Functions:** 1/2 matched (target 9)
- **Missing functions:** `traverse`
- **Types:** 0/5 matched (target 6)
- **Missing types:** `Sealed`, `TreeIterExt`, `TreeEntryRefExt`, `TreeEntryExt`, `TreeDiffChangeExt`

### 4. gix.attribute_stack

- **Target:** `gix.AttributeStack`
- **Similarity:** 0.07
- **Dependents:** 2
- **Priority Score:** 2060709.2
- **Functions:** 1/6 matched (target 2)
- **Missing functions:** `new`, `detach`, `deref`, `deref_mut`, `at_entry`
- **Types:** 0/1 matched
- **Missing types:** `Target`

### 5. gix.path

- **Target:** `gix.Path`
- **Similarity:** 0.00
- **Dependents:** 2
- **Priority Score:** 2010110.0
- **Functions:** 0/1 matched (target 6)
- **Missing functions:** `install_dir`
- **Types:** 0/0 matched (target 2)
- **Missing types:** _none_

### 6. gix.state

- **Target:** `gix.State [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 2
- **Priority Score:** 2000110.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 1/1 matched (target 2)
- **Missing types:** _none_

### 7. gix.id

- **Target:** `gix.Id`
- **Similarity:** 0.11
- **Dependents:** 1
- **Priority Score:** 1162008.9
- **Functions:** 4/18 matched (target 19)
- **Missing functions:** `object`, `header`, `try_object`, `try_header`, `calculate_auto_hex_len`, `deref`, `ancestors`, `hash`, `partial_cmp`, `eq`, `fmt`, `as_ref`, `from`, `size_of_oid`
- **Types:** 0/2 matched (target 4)
- **Missing types:** `Error`, `Target`
- **Tests:** 0/1 matched

### 8. ext.reference

- **Target:** `ext.Reference`
- **Similarity:** 0.83
- **Dependents:** 1
- **Priority Score:** 1010201.7
- **Functions:** 1/1 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 0)
- **Missing types:** `ReferenceExt`

### 9. gix.progress

- **Target:** `gix.Progress [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 1
- **Priority Score:** 1000010.0
- **Functions:** 0/0 matched (target 4)
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 2)
- **Missing types:** _none_

### 10. object.mod

- **Target:** `objs.Kind [STUB]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 232310.0
- **Functions:** 0/22 matched (target 0)
- **Missing functions:** `attach`, `fmt`, `from_data`, `into_blob`, `into_tree`, `into_commit`, `into_tag`, `try_into_commit`, `try_into_tag`, `try_into_tree`, `try_into_blob`, `detached`, `detach`, `to_commit_ref`, `try_to_commit_ref`, `to_commit_ref_iter`, `try_to_commit_ref_iter`, `to_tag_ref_iter`, `try_to_tag_ref_iter`, `to_tag_ref`, `try_to_tag_ref`, `id`
- **Types:** 0/1 matched
- **Missing types:** `Error`

### 11. gix.interrupt

- **Target:** `gix.Interrupt`
- **Similarity:** 0.12
- **Dependents:** 0
- **Priority Score:** 172008.8
- **Functions:** 3/15 matched (target 4)
- **Missing functions:** `deregister`, `with_reset`, `auto_deregister`, `drop`, `init_handler`, `new`, `into_inner`, `inner`, `next`, `read`, `fill_buf`, `consume`
- **Types:** 0/5 matched (target 2)
- **Missing types:** `Deregister`, `AutoDeregister`, `Iter`, `Item`, `Read`

### 12. gix.create

- **Target:** `gix.Create [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 131310.0
- **Functions:** 0/8 matched (target 0)
- **Missing functions:** `at`, `as_mut`, `drop`, `write_file`, `create_dir`, `into`, `key`, `bool`
- **Types:** 0/5 matched (target 9)
- **Missing types:** `Error`, `Kind`, `PathCursor`, `NewDir`, `Options`

### 13. gix.commit

- **Target:** `gix.Commit`
- **Similarity:** 0.07
- **Dependents:** 0
- **Priority Score:** 111409.3
- **Functions:** 1/10 matched (target 2)
- **Missing functions:** `from`, `format_with_dirty_suffix`, `names`, `traverse_first_parent`, `max_candidates`, `id_as_fallback`, `try_format`, `try_resolve_with_cache`, `try_resolve`
- **Types:** 2/4 matched (target 11)
- **Missing types:** `Error`, `Platform`

### 14. gix.filter

- **Target:** `gix.Filter [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 101010.0
- **Functions:** 0/8 matched (target 0)
- **Missing functions:** `options`, `new`, `into_parts`, `convert_to_git`, `convert_to_worktree`, `worktree_file_to_object`, `driver_context_mut`, `extract_drivers`
- **Types:** 0/2 matched (target 3)
- **Missing types:** `Error`, `Pipeline`

### 15. gix.discover

- **Target:** `gix.Discover [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 60610.0
- **Functions:** 0/5 matched (target 0)
- **Missing functions:** `discover`, `discover_opts`, `discover_with_environment_overrides`, `discover_with_environment_overrides_opts`, `apply_additional_environment`
- **Types:** 0/1 matched (target 4)
- **Missing types:** `Error`

### 16. gix.types

- **Target:** `gix.Types`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 41810.0
- **Functions:** 0/1 matched (target 26)
- **Missing functions:** `drop`
- **Types:** 14/17 matched (target 16)
- **Missing types:** `Id`, `Tree`, `AttributeStack`

### 17. gix.env

- **Target:** `gix.Env`
- **Similarity:** 0.13
- **Dependents:** 0
- **Priority Score:** 40708.7
- **Functions:** 3/6 matched (target 5)
- **Missing functions:** `args_os`, `args_os_opt`, `os_str_to_bstring`
- **Types:** 0/1 matched (target 12)
- **Missing types:** `Error`

### 18. gix.util

- **Target:** `gix.Util`
- **Similarity:** 0.08
- **Dependents:** 0
- **Priority Score:** 40609.2
- **Functions:** 1/4 matched (target 5)
- **Missing functions:** `deref`, `from`, `parallel_iter_drop`
- **Types:** 1/2 matched
- **Missing types:** `Target`

### 19. gix.init

- **Target:** `gix.Init [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 30310.0
- **Functions:** 0/2 matched (target 0)
- **Missing functions:** `init`, `init_opts`
- **Types:** 0/1 matched (target 6)
- **Missing types:** `Error`

### 20. gix.shallow

- **Target:** `gix.Shallow [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 20210.0
- **Functions:** 0/0 matched (target 2)
- **Missing functions:** _none_
- **Types:** 0/2 matched (target 6)
- **Missing types:** `CommitsStorage`, `Commits`

### 21. ext.rev_spec

- **Target:** `ext.RevSpec`
- **Similarity:** 0.55
- **Dependents:** 0
- **Priority Score:** 10204.5
- **Functions:** 1/1 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched
- **Missing types:** `RevSpecExt`

### 22. gix.push

- **Target:** `gix.Push [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 10110.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 2)
- **Missing types:** `Default`

### 23. gix.tag

- **Target:** `gix.Tag`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 5)
- **Missing types:** `Error`

### 24. submodule.errors

- **Target:** `submodule.Errors`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 30)
- **Missing types:** `Error`

### 25. gix.mailmap

- **Target:** `gix.Mailmap`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 6)
- **Missing types:** `Error`

### 26. parse.types

- **Target:** `parse.Types`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 300.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

## Reexport / Wiring Modules

These files match `reexport_modules` patterns in `.ast_distance_config.json`. They are filtered out of
normal priority and missing-file ladders because they are wiring
modules, not direct logic ports. Consult them for call-site routing;
do not treat them as the next implementation target by default.

### Matched

| Source | Target | Path |
|--------|--------|------|
| `gix.lib` | `gix.Gix` | `gix/src/lib` |
| `gix.prelude` | `gix.Prelude` | `gix/src/prelude` |

### Missing

| Source | Expected target | Deps | Source path | Expected path |
|--------|-----------------|------|-------------|---------------|
| `clone.mod` | `gix.src.clone.Mod` | 0 | `gix/src/clone/mod.rs` | `gix/src/clone/Mod.kt` |
| `config.mod` | `gix.src.config.Mod` | 0 | `gix/src/config/mod.rs` | `gix/src/config/Mod.kt` |
| `dirwalk.mod` | `gix.src.dirwalk.Mod` | 0 | `gix/src/dirwalk/mod.rs` | `gix/src/dirwalk/Mod.kt` |
| `ext.mod` | `gix.src.ext.Mod` | 0 | `gix/src/ext/mod.rs` | `gix/src/ext/Mod.kt` |
| `head.mod` | `gix.src.head.Mod` | 0 | `gix/src/head/mod.rs` | `gix/src/head/Mod.kt` |
| `open.mod` | `gix.src.open.Mod` | 0 | `gix/src/open/mod.rs` | `gix/src/open/Mod.kt` |
| `reference.mod` | `gix.src.reference.Mod` | 0 | `gix/src/reference/mod.rs` | `gix/src/reference/Mod.kt` |
| `remote.mod` | `gix.src.remote.Mod` | 0 | `gix/src/remote/mod.rs` | `gix/src/remote/Mod.kt` |
| `repository.mod` | `gix.src.repository.Mod` | 0 | `gix/src/repository/mod.rs` | `gix/src/repository/Mod.kt` |
| `revision.mod` | `gix.src.revision.Mod` | 0 | `gix/src/revision/mod.rs` | `gix/src/revision/Mod.kt` |
| `status.mod` | `gix.src.status.Mod` | 0 | `gix/src/status/mod.rs` | `gix/src/status/Mod.kt` |
| `submodule.mod` | `gix.src.submodule.Mod` | 0 | `gix/src/submodule/mod.rs` | `gix/src/submodule/Mod.kt` |
| `worktree.mod` | `gix.src.worktree.Mod` | 0 | `gix/src/worktree/mod.rs` | `gix/src/worktree/Mod.kt` |

