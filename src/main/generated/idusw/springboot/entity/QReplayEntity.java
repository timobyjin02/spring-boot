package idusw.springboot.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReplayEntity is a Querydsl query type for ReplayEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReplayEntity extends EntityPathBase<ReplayEntity> {

    private static final long serialVersionUID = 1177950806L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReplayEntity replayEntity = new QReplayEntity("replayEntity");

    public final QBoardEntity board;

    public final StringPath replier = createString("replier");

    public final NumberPath<Long> rno = createNumber("rno", Long.class);

    public final StringPath text = createString("text");

    public QReplayEntity(String variable) {
        this(ReplayEntity.class, forVariable(variable), INITS);
    }

    public QReplayEntity(Path<? extends ReplayEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReplayEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReplayEntity(PathMetadata metadata, PathInits inits) {
        this(ReplayEntity.class, metadata, inits);
    }

    public QReplayEntity(Class<? extends ReplayEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoardEntity(forProperty("board"), inits.get("board")) : null;
    }

}

