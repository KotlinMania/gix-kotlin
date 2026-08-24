package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId as HashObjectId
import io.github.kotlinmania.gix.objs.Entry as ObjsEntry
import io.github.kotlinmania.gix.objs.EntryKind as ObjsEntryKind
import io.github.kotlinmania.gix.objs.EntryMode as ObjsEntryMode
import io.github.kotlinmania.gix.objs.Tree as ObjsTree

typealias ObjectId = HashObjectId
typealias Tree = ObjsTree
typealias Entry = ObjsEntry
typealias EntryKind = ObjsEntryKind
typealias EntryMode = ObjsEntryMode
