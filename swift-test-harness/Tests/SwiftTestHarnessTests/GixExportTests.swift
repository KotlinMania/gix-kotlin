import Testing
import Gix

@Suite("Gix Export Smoke Tests")
struct GixExportTests {
    @Test("Swift module loads and instantiates types cleanly")
    func testSwiftModuleLoads() throws {
        let hex = "e69de29bb2d1d6434b8b29ae775ad8c2e48c5391"
        let oid = ExportedKotlinPackages.io.github.kotlinmania.gix.hash.ObjectId.Companion.shared.fromHex(hex: hex)
        #expect(oid.toHex() == hex)
        #expect(!oid.isNull())

        let repo = Gix.shared.open(directory: "/tmp/repo")
        #expect(repo.workdir() == "/tmp/repo")
        #expect(repo.gitDir == "/tmp/repo/.git")
        #expect(!repo.isBare)

        let id = Id(inner: oid, repo: repo)
        #expect(id.shorten(length: 7) == "e69de29")

        let zero20Bytes = ExportedKotlinPackages.io.github.kotlinmania.gix.hash.ObjectId.Companion.shared.nullSha1().bytes
        let sha1Zero20 = ExportedKotlinPackages.io.github.kotlinmania.gix.hash.ObjectId.Companion.shared.hashSha1(data: zero20Bytes)
        #expect(sha1Zero20.toHex() == "6768033e216468247bd031a0a2d9876d79818f8f")

        let sha256Zero20 = ExportedKotlinPackages.io.github.kotlinmania.gix.hash.ObjectId.Companion.shared.hashSha256(data: zero20Bytes)
        #expect(sha256Zero20.toHex() == "de47c9b27eb8d300dbb5f2c353e632c393262cf06340c4fa7f1b40c4cbd36f90")
    }
}
